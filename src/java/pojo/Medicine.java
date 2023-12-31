package pojo;
// Generated Oct 13, 2022 3:34:44 AM by Hibernate Tools 4.3.1


import dao.daoMedicine;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import utility.imedUtil;

/**
 * Medicine generated by hbm2java
 */
@ManagedBean (name = "med")
public class Medicine  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String type;
     private Date expdate;
     private int stock;
     private int price;
     
     
     
    public List<Medicine> getAllMedicine() {
        daoMedicine med = new daoMedicine();
        List<Medicine> listMed = med.getAllMedicine();
        return listMed; 
    }
    
    public String deleteMed() {
        daoMedicine med = new daoMedicine();
        med.deleteMed(id);
        FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"PRODUCT DELETED",
                                                "!"));
       id = null;
       name = "";
       type = "";
       expdate = null;
       stock = 0;
       price = 0;
        return "dashboard";
    }
    
        public String editMed() {
        imedUtil frhn = new imedUtil();
        String validation = frhn.inputValid( name, price, stock);
        if (!validation.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"EDIT PRODUCT ERROR:",
							validation));
       id = null;
       name = "";
       type = "";
       expdate = null;
       stock = 0;
       price = 0;
            return "dashboard";
        } else {
            daoMedicine med = new daoMedicine();
            med.editMed(this);
                FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"EDIT PRODUCT SUCCESS :",
							""));
       id = null;
       name = "";
       type = "";
       expdate = null;
       stock = 0;
       price = 0;
        }      
        return "dashboard";
    }
    
    public String getById() {
        String ids = Integer.toString(id);
        daoMedicine med = new daoMedicine();
        List<Medicine> listMed = med.getbyID(ids);
        try {

            if (!listMed.isEmpty()) {
                id = listMed.get(0).id;
                name = listMed.get(0).name;
                type = listMed.get(0).type;
                expdate = listMed.get(0).expdate;
                stock = listMed.get(0).stock;
                price = listMed.get(0).price;
                return "editor";
            } else {
                FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"PRODUCT WITH ID: "+ids+" NOT FOUND",
							""));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "dashboard";
    }
    
    
    public String saveMed() {
        imedUtil frhn = new imedUtil();
        String validation = frhn.inputValid( name, price, stock);
            if (!validation.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"ADD PRODUCT ERROR:",
							validation));
            id = null;
            name = "";
            type = "";
            expdate = null;
            stock = 0;
            price = 0;
            return "dashboard";
            } else {

            daoMedicine med = new daoMedicine();
            med.addMed(this);
                FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"PRODUCT "+name+" ADDED !",
							""));
            id = null;
            name = "";
            type = "";
            expdate = null;
            stock = 0;
            price = 0;
            }
        return "dashboard";  
    }
       public String goBack(){

            id = null;
            name = "";
            type = "";
            expdate = null;
            stock = 0;
            price = 0;
       return "dashboard";
    }
    public Medicine() {
    }

    public Medicine(String name, String type, Date expdate, int stock, int price) {
       this.name = name;
       this.type = type;
       this.expdate = expdate;
       this.stock = stock;
       this.price = price;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Date getExpdate() {
        return this.expdate;
    }
    
    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    void setExpdate(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


