package br.com.deltatgn.desktop_mdi.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jlopes
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private boolean ativo;

}
