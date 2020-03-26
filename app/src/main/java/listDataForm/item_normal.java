package listDataForm;

public class item_normal {

    private String siteName;
    private String url;
    private String IDNumber;
    private int Logo;
    private String Email;
    private String ID;
    private String password;
    private String memo;
    private int type;


    public item_normal(int viewType){
        this.type = viewType;
    }


    public String getSiteName(){
        return siteName;
    }

    public String getUrl(){ return url; }

    public String getIDNumber(){
        return IDNumber;
    }

    public int getLogo(){
        return Logo;
    }

    public String getEmail(){
        return Email;
    }

    public String getID(){
        return ID;
    }

    public String getPassword(){
        return password;
    }

    public String getMemo(){
        return memo;
    }

    public int getType() { return this.type; }

    public void setSiteName(String sitename){
        this.siteName = sitename;
    }

    public void setUrl(String url){ this.url = url; }

    public void setIDNumber(String idNumber){
        this.IDNumber = idNumber;
    }

    public void setLogo(int logo){
        this.Logo = logo;
    }

    public void setEmail(String email){
        this.Email = email;
    }

    public void setID(String id){
        this.ID = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public void setType(int type) { this.type = type; }
}
