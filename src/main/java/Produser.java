/**
 * @author shenWenWen 2022/6/2 下午7:38
 *//*

public class Produser {

    //生产者  循环调用，进行生产
    class produce implements  Runnable{
        Store  store;
        Produser(Store store){
            this.store = store;
        }
        @Override
        public void run(){
            for (int i = 1; i < 100 ; i++) {
                store.into();//生产放入
            }
        }
    }
    //消费者 循环调用，进行消费
    class Consummer implements  Runnable{
        Store  store;
        Consummer(Store store){
            this.store = store;
        }
        @Override
        public void run(){
            for (int i = 1; i < 100 ; i++) {
                store.remove();//消费取出
            }
        }
    }
    //缓冲池

    private final  static  int Mx = 10;//上限
    private static int stock = 0;

    public  synchronized void into(){
        if (stock == Mx){
            try {
                this.wait();  //放入，同步方法等待
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        stock ++;
        this.notify();
    }
}
*/
