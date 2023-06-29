/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.TipoDeSala;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Departamento implements Serializable, Comparable<Departamento> {

    private String nome;
    private List<Curso> cursos;
    private List<Docente> docentes;
    private List<Sala> salas;

    public Departamento(String nome, List<Sala> salas) {
        this.nome = nome;
        this.salas = salas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento {\n");
        sb.append("  Nome: ").append(nome).append("\n");

        sb.append("  Cursos: ");
        if (cursos.isEmpty()) {
            sb.append("Nenhum curso cadastrado.\n");
        } else {
            sb.append("\n");
            for (Curso curso : cursos) {
                sb.append("    - ").append(curso.getNome()).append("\n");
            }
        }

        sb.append("  Docentes: ");
        if (docentes.isEmpty()) {
            sb.append("Nenhum docente cadastrado.\n");
        } else {
            sb.append("\n");
            for (Docente docente : docentes) {
                sb.append("    - ").append(docente.getNome()).append("\n");
            }
        }

        sb.append("  Salas: ");
        if (salas.isEmpty()) {
            sb.append("Nenhuma sala cadastrada.\n");
        } else {
            sb.append("\n");
            for (Sala sala : salas) {
                sb.append("    - ").append(sala.toString()).append("\n");
            }
        }

        sb.append("}\n");
        return sb.toString();
    }


    @Override
    public int compareTo(Departamento outroDepartamento) {
        return this.nome.compareTo(outroDepartamento.getNome());
    }

    public class Sala implements Serializable, Comparable<Sala> {

        private String nome;
        private TipoDeSala tipoDeSala;
        private int capacidade;
        private List<PeriodoOcupado> agenda;

        public Sala(String nome,TipoDeSala tipoDeSala, int capacidade) {
            this.nome = nome;
            this.capacidade = capacidade;
            this.tipoDeSala = tipoDeSala;
            this.agenda = new ArrayList<>();
        }

        public String getNome() {
            return nome;
        }

        public int getCapacidade() {
            return capacidade;
        }

        public List<PeriodoOcupado> getAgenda() {
            return agenda;
        }

        public void adicionarPeriodoOcupado(LocalDateTime inicio, LocalDateTime fim, Object actividade) {
            agenda.add(new PeriodoOcupado(inicio, fim, actividade));
        }

        public void removerPeriodoOcupado(PeriodoOcupado periodo) {
            agenda.remove(periodo);
        }

        public class PeriodoOcupado implements Serializable {

            private LocalDateTime inicio;
            private LocalDateTime fim;
            private Object actividade;//a actividade que ira decorrer durante o periodo ocupado: pode ser uma avaliacao ou tipo de aula

            public PeriodoOcupado(LocalDateTime inicio, LocalDateTime fim, Object actividade) {
                if(actividade instanceof Enum<?>){
                    this.actividade = (Enum<?>)actividade;
                }else if(actividade instanceof Avaliacao){
                    this.actividade = (Avaliacao)actividade;
                }else{
                    throw new IllegalArgumentException("A atividade a ser agendada em uma sala só pode ser uma avaliação ou aula.");
                }
                this.inicio = inicio;
                this.fim = fim;
                this.actividade = actividade;
            }

            public Object getActividade() {
                return actividade;
            }

            public LocalDateTime getInicio() {
                return inicio;
            }

            public LocalDateTime getFim() {
                return fim;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Das ").append(inicio.format(DateTimeFormatter.ofPattern("h:mma")))
                        .append(" até as ").append(fim.format(DateTimeFormatter.ofPattern("h:mma")))
                        .append(" ").append(fim.format(DateTimeFormatter.ofPattern("MMMM d yyyy")))
                        .append(", há ").append(actividade.toString());
                return sb.toString();
            }
        }

        @Override
        public int compareTo(Sala outraSala) {
            return this.nome.compareTo(outraSala.nome);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sala outraSala = (Sala) obj;
            return Objects.equals(nome, outraSala.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Detalhes da Sala:\n");
            sb.append("     Nome: ").append(nome).append("\n");
            sb.append("     Capacidade: ").append(capacidade).append(" pessoas\n");
            sb.append("     Tipo de Sala: ").append(tipoDeSala).append("\n");
            return sb.toString();
        }
    }
}
