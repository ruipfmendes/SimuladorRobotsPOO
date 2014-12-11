/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorrobots;

/**
 *
 * @author Rui Mendes
 */
public class Bloco extends Ambiente {
    private coordXY coordenadas;
    private Entidade[] entidadesNoBloco;

    public coordXY getCoordenadas() {
        return this.coordenadas;
    }
    public Entidade[] getEntidades() {
        return this.entidadesNoBloco;
    }
}
