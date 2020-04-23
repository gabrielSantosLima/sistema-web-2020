package com.principal.math.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.math.model.entity.Aluno;
import com.principal.math.model.repository.AlunoRepository;
import com.principal.math.utils.EntidadeLogin;

@Service
public class AlunoService extends GenericService<Aluno, AlunoRepository> {

	@Autowired
	private AlunoRepository repository;

	public boolean login(EntidadeLogin entidade) {
		try {

			for (Aluno aluno : this.listar()) {
				if (aluno.comparaAtributosLogin(entidade.getEmail(), entidade.getSenha())) {
					return true;
				}
			}

		} catch (Exception e) {

			System.out.println("Erro : " + e.getMessage());

		}
		return false;
	}

	public Aluno getAlunoByEmailAndSenha(String email, String senha) {
		return repository.findByEmailAndSenha(email, senha);
	}
}
