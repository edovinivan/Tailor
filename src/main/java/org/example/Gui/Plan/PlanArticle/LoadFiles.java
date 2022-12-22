/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

/**
 *
 * @author ivan
 * Загрузка фала продаж
 */
public class LoadFiles {
    
    private final Logger log = Logger.getLogger(LoadFiles.class);
    
    private List<ArticleLoad> articleLoad;
    
    

    public LoadFiles() {
    }

    public List<ArticleLoad> getArticleLoad() {
        return articleLoad;
    }
    
    
    
    /**
     * Загрузка из файла продаж
     * @param files - файл продаж
     * Столбцы
     * 1 - Группа номенклатуры
     * 2 - Цвет
     * 3 - Артикул
     * 4 - Количество
     * @return 
     */
    public boolean loadDataFromFileSale(String files){
        Path path = Paths.get(files);
        try {
            articleLoad =  Files.lines(path, Charset.forName("cp1251"))
                    .skip(2)
                    .filter((t)->{                        
                        if( t.split(";").length < 6 ) return false;                             
                        //артикул
                        if( t.split(";")[0] == null || t.split(";")[0].isEmpty()) return false;                                                
                        // цвер
                        if( t.split(";")[2] == null ||  t.split(";")[2].isEmpty()) return false;
                        // размер
                        if( t.split(";")[3] == null ||  t.split(";")[3].isEmpty()) return false;                        
                        
                        return getInt(t.split(";")[4])> 0;
                    })                    
                    .map((t)->{
                        
                        return new ArticleLoad(0, 0, t.split(";")[1], t.split(";")[0].replace("%","").trim() , t.split(";")[3], t.split(";")[2] , getInt(t.split(";")[4]) , 0, getInt(t.split(";")[5]));
                    })
                    .collect(Collectors.toList());
            
            
            Map<String, Integer> articleLoadGroupt =  articleLoad.stream()
                    .collect(Collectors.groupingBy(ArticleLoad::getArticle, Collectors.summingInt(ArticleLoad::getSumma_sale)));
            
            articleLoad.stream()
                    .forEach(t->{
                        t.setSumma_sale(articleLoadGroupt.get(t.getArticle()));
                    });
            
            articleLoad.sort((o1, o2) -> {
                return o2.getSumma_sale() - o1.getSumma_sale();
            });
                  
        } catch (IOException ex) {
            log.warn("IOException1 " + ex);
            return false;
        }
        return true;
    }
    
    /**
     * Получить из строки число
     * @param str - строка
     * @return 
     */
    private int getInt(String str){
        int r;
        if(str == null) return 0;
        if(str.isEmpty()) return 0;
        str = str.replace(" ", "").replace(",", ".");
        if(str.contains(".")){
            str = str.substring(0, str.indexOf("."));
        }
        try{
            r = Integer.parseInt(str);
        }catch(NumberFormatException e){
            log.info(e);
            return 0 ;
        }
        return r;
    }
 
    /**
     * Загрузить остатки из файла
     * @param nameFile
     * @return 
     */
    public boolean loadDataFromFileBalance(String nameFile){
        Path path = Paths.get(nameFile);
        try {
            articleLoad = Files.lines(path, Charset.forName("cp1251"))
                    .skip(3)
                    .filter(t -> {
                        if (t == null) return false;                        
                        if (t.isEmpty()) return false;                        
                        if(t.split(";").length < 12) return false;
                        
                        if( t.split(";")[0] == null || t.split(";")[0].isEmpty()) return false;
                        if( t.split(";")[2] == null || t.split(";")[2].isEmpty()) return false;
                        if( t.split(";")[3] == null || t.split(";")[3].isEmpty()) return false;
                                                
                        return (getInt(t.split(";")[11]) != 0);
                    })
                    .map(t->{                        
                        return new ArticleLoad(0, 0, t.split(";")[1], t.split(";")[0], t.split(";")[3], t.split(";")[2], 0, getInt(t.split(";")[11]), 0);
                    })
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            log.error(ex);
            return false;
        }
        return true;
    }
    
}
