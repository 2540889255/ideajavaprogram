package com.aynu.test.testthread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author admin
 */
public class TestThreadReadAndWriteLock {

    public static class ProductInfo{

        private double Price1;

        private double Price2;

        private ReadWriteLock lock;

        public ProductInfo() {
            Price1 = 2.0;
            Price2 = 3.0;
            this.lock = new ReentrantReadWriteLock();
        }

        public double getPrice1(){
            lock.readLock().lock();
            double value = Price1;
            lock.readLock().unlock();
            return value;
        }

        public double getPrice2() {
            lock.readLock().lock();
            double value = Price2;
            lock.readLock().unlock();
            return value;
        }

        public void setPrices(double price1,double price2){
            
        }
    }

}
