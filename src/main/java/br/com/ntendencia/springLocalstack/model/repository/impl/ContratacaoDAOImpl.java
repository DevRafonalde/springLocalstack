package br.com.ntendencia.springLocalstack.model.repository.impl;

import br.com.ntendencia.springLocalstack.model.entity.Contratacao;
import br.com.ntendencia.springLocalstack.model.entity.Seguro;
import br.com.ntendencia.springLocalstack.model.repository.ContratacaoDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ContratacaoDAOImpl extends JdbcDaoSupport implements ContratacaoDAO {
    DataSource dataSource;

    public ContratacaoDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertContratacao(Contratacao contratacao) {
        String sql = "INSERT INTO contratacao " +
                "(id, nome, cpfCnpj, seguros, cep) VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                contratacao.getId(),
                contratacao.getNome(),
                contratacao.getCpfCnpj(),
                contratacao.getSegurosContratados(),
                contratacao.getCep()
        });
    }

    @Override
    public List<Contratacao> getAllContratacoes(){
        String sql = "SELECT * FROM contratacao";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Contratacao> contratacoes = new ArrayList<>();
        for(Map<String, Object> row:rows){
            Contratacao contratacao = new Contratacao();
            contratacao.setId((Integer) row.get("id"));
            contratacao.setNome((String)row.get("nome"));
            contratacao.setCpfCnpj((String)row.get("nome"));
            contratacao.setSegurosContratados((Set<Seguro>) row.get("seguro"));
            contratacao.setCep((String)row.get("nome"));
            contratacoes.add(contratacao);
        }

        return contratacoes;
    }

    @Override
    public Contratacao getContratacaoById(Integer id) {
        String sql = "SELECT * FROM contratacao WHERE id = ?";
        return (Contratacao) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Contratacao>(){
            @Override
            public Contratacao mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Contratacao contratacao = new Contratacao();
                contratacao.setId(Integer.parseInt(rs.getString("empId")));
                contratacao.setNome(rs.getString("nome"));
                contratacao.setCpfCnpj(rs.getString("cpfCnpj"));
                contratacao.setSegurosContratados((Set<Seguro>) rs.getArray("seguros"));
                return contratacao;
            }
        });
    }
}
