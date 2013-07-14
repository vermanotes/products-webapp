package org.productapp.infrastructure.jaxb;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "list")
public class GenericListElementWrapper<T> {
    private List<T> list;

    public GenericListElementWrapper() {
    }

    public GenericListElementWrapper(List<T> list) {
        this.list = list;
    }

    @XmlAnyElement(lax = true)
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
