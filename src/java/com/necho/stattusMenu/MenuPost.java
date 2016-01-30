package com.necho.stattusMenu;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
public class MenuPost {

    private String console;

    private String postwith;
    private List<PostWith> postwithall;

   
    private List<PostWith> postwithlist;

    @ManagedProperty("#{postService}")
    private PostService service;

    @PostConstruct
    public void init() {
        //postwith
//        SelectItemGroup g1 = new SelectItemGroup("Public");
//        SelectItem[] gro1 = new SelectItem[]{new SelectItem("All friends", "All friends Only your  friends can see this post ", "Only your  friends can see this post "),
//            new SelectItem("All ", "Mercedes", "All "),
//            new SelectItem("Volkswagen", "Volkswagen")};
//        g1.setSelectItems(gro1);
//
//        SelectItemGroup g2 = new SelectItemGroup("American Cars");
//        g2.setSelectItems(new SelectItem[]{new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});
//
//        postwithall = new ArrayList<SelectItem>();
//        postwithall.add(g1);
//        postwithall.add(g2);
       

        //themes
        postwithall = service.getPostwithlist();
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

   

    public String getPostwith() {
        return postwith;
    }

    public void setPostwith(String postwith) {
        this.postwith = postwith;
    }

    public List<PostWith> getPostwithall() {
        return postwithall;
    }

    public void setPostwithall(List<PostWith> postwithall) {
        this.postwithall = postwithall;
    }

    public List<PostWith> getPostwithlist() {
        return postwithlist;
    }

    public void setService(PostService service) {
        this.service = service;
    }
}
