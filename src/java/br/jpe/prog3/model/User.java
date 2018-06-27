/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.model;

import br.jpe.prog3.core.Model;
import br.jpe.prog3.core.Parse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

/**
 * Users table model
 *
 * @author joaovperin
 */
public class User extends Model<User> {

    /*
        Table Usuarios (
	idUsuario integer not null,
        endEmail varchar( 120 ) not null,
        dtInclusao timestamp not null default current_timestamp,
        nome varchar( 200 ) not null,
        senha varchar( 32 ) not null,
        dtNascimento timestamp,
        primary key( idUsuario )
     */
    private int idUsuario;
    private String endEmail;
    private Date dtInclusao;
    private String nome;
    private String senha;
    private Date dtNascimento;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEndEmail() {
        return endEmail;
    }

    public void setEndEmail(String endEmail) {
        this.endEmail = endEmail;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String fmtDataNascimento() {
        return Parse.fromDate(getDtNascimento());
    }

    @Override
    public User get(ResultSet rs) throws SQLException {
        int i = 1;
        setIdUsuario(rs.getInt(i++));
        setEndEmail(rs.getString(i++));
        setDtInclusao(new Date(rs.getDate(i++).getTime()));
        setNome(rs.getString(i++));
        setSenha(rs.getString(i++));
        setDtNascimento(new Date(rs.getDate(i++).getTime()));
        return this;
    }

    @Override
    public void set(PreparedStatement pstm) throws SQLException {
        int i = 1;
        // Auto incremeted column
        if (getIdUsuario() != 0) {
            pstm.setInt(i++, getIdUsuario());
        } else {
            pstm.setNull(i++, Types.INTEGER);
        }
        pstm.setString(i++, getEndEmail());
        pstm.setDate(i++, getDtInclusao() == null ? null : new java.sql.Date(getDtInclusao().getTime()));
        pstm.setString(i++, getNome());
        pstm.setString(i++, getSenha());
        pstm.setDate(i++, getDtNascimento() == null ? null : new java.sql.Date(getDtNascimento().getTime()));
    }

    @Override
    public String sqlPersist() {
        return "INSERT INTO Usuarios VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE idUsuario = idUsuario";
    }

}
