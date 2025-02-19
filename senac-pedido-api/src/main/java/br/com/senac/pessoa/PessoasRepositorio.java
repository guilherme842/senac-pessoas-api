package br.com.senac.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRepositorio extends JpaRepository<Pessoas, Long> {
}

@service
public class PessoaService {

    @Autowired
    private PessoasRepositorio pessoasRepositorio;
    /*
    public  PessoasService(PessoasRepositorio pessoasRepositorio) {
        this.pessoasRepositorio=pessoasRepositorio;
    }
    */
    public Pessoas criarPessoa(Pessoas pessoa) {
        try {
            Pessoas pessoasResult = pessoasRepositorio.save(pessoa);

            return pessoasResult;
        } catch (Exception e) {
            throws new RunTimeException(e.getMessage());
        }
    }
}
