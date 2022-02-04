package br.edu.senai.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.edu.senai.entidade.Funcionario;



public class FuncionarioDao extends Dao {
	
	
	public void create(Funcionario f) throws Exception{		
		open();
			stmt = con.prepareStatement("insert into funcionario values(null,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setDouble(2, f.getSalario());
			stmt.execute();
			stmt.close();
		close();		
	}

	public void delete(int cod) throws Exception{		
		open();
			stmt = con.prepareStatement("delete from funcionario where idFuncionario = ?");
			stmt.setInt(1, cod);
			stmt.execute();
			stmt.close();
		close();		
	}

	public void update(Funcionario f) throws Exception{		
		open();
			stmt = con.prepareStatement("update funcionario set nome = ? , salario = ? where idFuncionario = ?");
			stmt.setString(1, f.getNome());
			stmt.setDouble(2, f.getSalario());
			stmt.setInt(3, f.getIdFuncionario());
			stmt.execute();
			stmt.close();
		close();		
	}
	
	public List findAll() throws Exception{		
		open();
			stmt = con.prepareStatement("select * from funcionario");
			rs = stmt.executeQuery();
				List lista = new ArrayList();
			while(rs.next()){
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setSalario(rs.getDouble(3));
				lista.add(funcionario);
			}
			stmt.close();
		close();
		return lista;
	}
	
	public Funcionario findByCode(int cod) throws Exception{		
		open();
			stmt = con.prepareStatement("select * from Funcionario where idFuncionario = ?");
			stmt.setInt(1, cod);	
			rs = stmt.executeQuery();
				Funcionario funcionario	= null;			
			if(rs.next()){
				funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setSalario(rs.getDouble(3));
				
			}
			stmt.close();
		close();
		return funcionario;
	}	
}  