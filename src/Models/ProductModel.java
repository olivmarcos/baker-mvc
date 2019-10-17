/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author marco
 */
public class ProductModel {
    
    private int id;
    private String name;
    private double price;
    private String unity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
    
    public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getId());
        vetor[1] = getName();
        vetor[2] = String.valueOf(getPrice());
        vetor[3] = getUnity();
        
        return vetor;
    }
    
    public void vetorTo(String[] dados) {
        this.setId(Integer.parseInt(dados[0]));
        this.setName(dados[1]);
        this.setPrice(Double.parseDouble(dados[2]));
        this.setUnity(dados[3]);
    }
}
