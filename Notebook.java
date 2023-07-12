public class Notebook{
    private int sizeMainMemory;  
    private int sizeHardDrive;  
    private float diagonal;  
    private int price;  
    private String processor;  
    private String model;  
    private String brand;  
    private String os; 
    public  Notebook(String brand, String model, int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public  Notebook(String brand, String model, int price, int sizeMainMemory, int sizeHardDrive, float diagonal, String processor, String os){
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
    public float getDiagonal(){
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
    @Override
    public String toString(){
        return "Производитель: " + brand + ", Модель: " + model + ", Стоимость: " + price + ", Процессор: " + processor;
    }

}