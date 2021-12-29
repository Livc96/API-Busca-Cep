//package com.example.BuscaCEP.model;
//
//import com.example.BuscaCEP.confi.Views;
//import com.fasterxml.jackson.annotation.JsonView;
//
//import java.util.List;
//
//public class Retorno<T> {
//    private T resultado;
//
//    private Excecao excecao;
//
//    @JsonView(Views.Paginado.class)
//    private long totalRegistros;
//
//    @JsonView(Views.Paginado.class)
//    private long paginaAtual;
//
//    @JsonView(Views.Paginado.class)
//    private long tamanhoPagina;
//
//    @JsonView(Views.Paginado.class)
//    private long totalPaginas;
//
//    @JsonView(Views.Paginado.class)
//    private boolean primeiraPagina;
//
//    @JsonView(Views.Paginado.class)
//    private boolean ultimaPagina;
//
//    public Retorno() {
//
//    }
//
//    public Retorno(final T resultado) {
//        this.resultado = resultado;
//    }
//
//    public Retorno(final T resultado, final long pagina, final long totalPagina) {
//        this(resultado);
//
//        this.paginaAtual = pagina;
//        this.tamanhoPagina = totalPagina;
//
//        if (getResultado() != null && getResultado() instanceof List<?>) {
//            for (Object object : (List<?>) getResultado()) {
//                if (object instanceof Paginado) {
//                    this.totalRegistros = ((Paginado) object).getTotal();
//                    this.totalPaginas = getTotalRegistros() / getTamanhoPagina()
//                            + (getTotalRegistros() % getTamanhoPagina() > 0 ? 1 : 0);
//                    this.primeiraPagina = getPaginaAtual() == 1;
//                    this.ultimaPagina = getPaginaAtual() == getTotalPaginas();
//                    break;
//                }
//            }
//        }
//    }
//
//    public T getResultado() {
//        return resultado;
//    }
//
//    public void setResultado(final T resultado) {
//        this.resultado = resultado;
//    }
//
//    public Excecao getExcecao() {
//        return excecao;
//    }
//
//    public void setExcecao(final Excecao excecao) {
//        this.excecao = excecao;
//    }
//
//    public long getTotalRegistros() {
//        return totalRegistros;
//    }
//
//    public void setTotalRegistros(final long totalRegistros) {
//        this.totalRegistros = totalRegistros;
//    }
//
//    public long getPaginaAtual() {
//        return paginaAtual;
//    }
//
//    public void setPaginaAtual(final long paginaAtual) {
//        this.paginaAtual = paginaAtual;
//    }
//
//    public long getTamanhoPagina() {
//        return tamanhoPagina;
//    }
//
//    public void setTamanhoPagina(final long tamanhoPagina) {
//        this.tamanhoPagina = tamanhoPagina;
//    }
//
//    public long getTotalPaginas() {
//        return totalPaginas;
//    }
//
//    public void setTotalPaginas(final long totalPaginas) {
//        this.totalPaginas = totalPaginas;
//    }
//
//    public boolean isPrimeiraPagina() {
//        return primeiraPagina;
//    }
//
//    public void setPrimeiraPagina(final boolean primeiraPagina) {
//        this.primeiraPagina = primeiraPagina;
//    }
//
//    public boolean isUltimaPagina() {
//        return ultimaPagina;
//    }
//
//    public void setUltimaPagina(final boolean ultimaPagina) {
//        this.ultimaPagina = ultimaPagina;
//    }
//}
