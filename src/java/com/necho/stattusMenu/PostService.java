package com.necho.stattusMenu;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import com.necho.stattusMenu.PostWith;
 
@ManagedBean(name="postService", eager = true)
@ApplicationScoped
public class PostService {
     
    private List<PostWith> postwithlist;
     
    @PostConstruct
    public void init() {
        postwithlist = new ArrayList<PostWith>();
        postwithlist.add(new PostWith(0, "Afterdark", "afterdark"));
        postwithlist.add(new PostWith(1, "Afternoon", "afternoon"));
        postwithlist.add(new PostWith(2, "Afterwork", "afterwork"));
       
    }
     
    public List<PostWith> getPostwithlist() {
        return postwithlist;
    } 
}