import Containers.ClassicContainer;

import java.util.LinkedList;

public class Train {

    LinkedList<ClassicContainer> trainset = new LinkedList<>();


    void loadContainer(LinkedList<ClassicContainer> containers) throws InterruptedException {

        Thread loading = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < containers.size(); i++) {
                   if (trainset.size() >= 1) {
                       try {
                           Thread.sleep(30000);
                           trainset.clear();
                           System.out.println("Loading completed - train");
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   } else {
                       trainset.add(containers.get(i));
                   }
               }
           }
       });

       loading.start();

       try {
           loading.join();
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }


}
