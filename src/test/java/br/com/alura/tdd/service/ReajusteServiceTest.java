package br.com.alura.tdd.service;
/*
 * @author allfel
 *
 * Data: 23/01/2023
 */

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        reajusteService = new ReajusteService();
        funcionario = new Funcionario("Allan", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void deveReajustarOSalarioEm3PorCentoParaDesempenhoADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarOSalarioEm15PorCentoParaDesempenhoBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarOSalarioEm20PorCentoParaDesempenhoOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarOSalarioEm0PorCentoParaDesempenhoRuim() {
        reajusteService.concederReajuste(funcionario, Desempenho.RUIM);
        assertEquals(new BigDecimal("1000.00"), funcionario.getSalario());
    }

}