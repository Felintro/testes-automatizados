package br.com.alura.tdd.modelo;
/*
 * @author allfel
 *
 * Data: 23/01/2023
 */

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.03);
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.15);
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.20);
        }
    },
    RUIM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.00);
        }
    };

    public abstract BigDecimal percentualReajuste();

}
