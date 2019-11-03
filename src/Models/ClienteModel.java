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
public class ClienteModel {
    private int id;
    private String name;
    private String endereco;
    private int cpf;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
        public String[] toVetor() {
        String vetor[] = new String[4];
        vetor[0] = String.valueOf(getId());
        vetor[1] = getName();
        vetor[2] = getEndereco();
        vetor[3] = String.valueOf(getCpf());
        
        return vetor;
    }
    
    public void vetorTo(String[] dados) {
        this.setId(Integer.parseInt(dados[0]));
        this.setName(dados[1]);
        this.setEndereco(dados[2]);
        this.setCpf(Integer.parseInt(dados[3]));
    }
}
