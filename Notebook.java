public class Notebook{
    private int sizeMainMemory;  
    private int sizeHardDrive;  
    private int diagonal;  
    private int price;  
    private String processor;  
    private String model;  
    private String brand;  
    private String os; 
    public void Notebook(String brand, String model, int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public void Notebook(String brand, String model, int price, int sizeMainMemory, int sizeHardDrive, int diagonal, String processor, String os){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.os = os;
        this.diagonal = diagonal;
        this.sizeHardDrive = sizeHardDrive;
        this.sizeMainMemory = sizeMainMemory;
        this.processor = processor;
    }
    public int getSizeMainMemory(){
        return sizeMainMemory;
    }
    public int getSizeHardDrive(){
        return sizeHardDrive;
    }
    public int getDiagonal(){
        return diagonal;
    }
    public int getPrice(){
        return price;
    }
    public String getProcessor(){
        return processor;
    } 
    public String getModel(){
        return model;
    }
    public String getBrand(){
        return brand;
    }
    public String getOs(){
        return os;
    }
}