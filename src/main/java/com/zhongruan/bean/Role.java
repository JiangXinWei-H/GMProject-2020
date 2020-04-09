package com.zhongruan.bean;

/**
 *  实体类模型，映射数据字段的模型/对象
 */
public class Role {

    private int rid;
    private String rname;
    private String rdesc;

    // get / set  对象.get / set
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    //  new 对象(属性，属性，属性....)
    public Role() {
    }

    public Role(int rid, String rname, String rdesc) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}
