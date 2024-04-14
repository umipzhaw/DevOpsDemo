package ch.zhaw.iwi.devops.demo;

public class mountain {
    
    private int id;
    private String title;
    private String mountain_type;



    public mountain() {
    }
    
    public mountain (int id, String title, String mountain_type) {
        this.id = id;
        this.title = title;
        this.mountain_type = mountain_type;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getmountain_type() {
        return mountain_type;
    }

    public void setmountain_type(String mountain_type) {
        this.mountain_type = mountain_type;
    }
   
    public void setTitle(String title) {
        this.title = title;
    }
}

