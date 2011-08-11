package org.signserver.server.genericws.test;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * TODO: Document me!
 * 
 * @version $Id$
 */
@Entity
public class ShelfDataBean {

    @Id
    String name;
    int counter = 0;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void incrementCounter() {
        counter++;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
