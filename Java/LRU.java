import java.util.LinkedList;
/**
 *
 *Given function takes cache size, pages and pages size. Function returns number of cache mises.
 */
public class LRUCache {
    
    static public int lruFunction(int max_cache_size,int frames[],int frame_size){
         LinkedList<Integer> current_cache = new LinkedList<>();
         int i,temp,index,count=0;
         if(frame_size>0){
             for(i=0;i<max_cache_size;i++){
                count++;
                current_cache.add(frames[i]);
             }
         }else{
             return 0;
         }
         for(; i < frames.length; i++) {
            if(current_cache.contains(frames[i])){
               temp = frames[i];
               index = current_cache.indexOf(temp);
               current_cache.remove(index);
               current_cache.addLast(temp);
            }else{
                count++;
                temp = frames[i];
                current_cache.removeFirst();
                current_cache.addLast(temp);
             } 
         }
       return count; 
    }    
}
public class PracticeSession {
    
    public static void main(String[] args)throws Exception{
       int cache_size=2,pages[]={2,3,1,3,2,1,4,3,2},page_size=9;
        System.out.println(LRUCache.lruFunction(a, b, c));
    }   
}
//output is: 8 
