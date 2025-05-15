package org.serratec.backend.controller;

import org.serratec.backend.entity.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private static List<Aluno> alunos = new ArrayList<>();

    static {
        alunos.add(new Aluno(123L, "Adriano", "adriano@gmail.com"));
        alunos.add(new Aluno(321L, "Bob", "bob@gmail.com"));
        alunos.add(new Aluno(345L, "David", "david@gmail.com"));
        alunos.add(new Aluno(545L, "John", "john@gmail.com"));
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    @GetMapping("/{matricula}")
    public Aluno buscar(@PathVariable Long matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    @PostMapping("/varios")
    public List<Aluno> inserirVarios(@RequestBody List<Aluno> novosAlunos) {
        alunos.addAll(novosAlunos);
        return alunos;
    }

    @DeleteMapping("/{matricula}")
    public void apagar(@PathVariable Long matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunos.remove(aluno);
                break;
            }
        }
    }

    @PutMapping("/{matricula}")
    public Aluno atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                aluno.setMatricula(matricula);
                alunos.set(alunos.indexOf(a), aluno);
                return a;
            }
        }
        return null;
    }
}
