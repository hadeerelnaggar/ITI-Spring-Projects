package iti.hadeer;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ScopesTest implements InitializingBean, DisposableBean {
    List<Object> list;

    public void init() {
        System.out.println("Init");
    }

    public void setList(List<Object> list){
        this.list = list;
    }

    public void dest(){
        System.out.println("Dest function");
    }

    @Override
    public void destroy() {
        System.out.println("Destroyy");
    }

    public ScopesTest() {
        System.out.println("ScopesTest default constructor");
    }

    public ScopesTest(List<Object> list){
        this.list = list;
    }

    public void printList(){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init from interface");
    }

}
