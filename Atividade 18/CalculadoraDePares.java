/**
 * CalculadoraDePares
 */
public class CalculadoraDePares {

    public int somar(int x, int y){
        try{
            if ( x%2 != 0){
                throw new NaoParExcepition(x);
            }
            if ( y%2 != 0){
                throw new NaoParExcepition(y);
            }
            int soma = x + y;
            return soma;
        } catch(NaoParExcepition e){
            System.out.println(e);
            return 0;
        }
    }
    public int subtrair(int x, int y){
        try{
            if ( x%2 != 0){
                throw new NaoParExcepition(x);
            }
            if ( y%2 != 0){
                throw new NaoParExcepition(y);
            }
            int subtrair = x - y;
            return subtrair;
        } catch(NaoParExcepition e){
            System.out.println(e);
            return 0;
        }
    }
    public int multiplicar(int x, int y){
        try{
            if ( x%2 != 0){
                throw new NaoParExcepition(x);
            }
            if ( y%2 != 0){
                throw new NaoParExcepition(y);
            }
            int multiplicacao = x * y;
            return multiplicacao;
        } catch(NaoParExcepition e){
            System.out.println(e);
            return 0;
        }
    }
    public int dividir(int x, int y){
        try{
            if ( x%2 != 0){
                throw new NaoParExcepition(x);
            }
            if ( y%2 != 0){
                throw new NaoParExcepition(y);
            }
            if (y == 0){
                throw new Error();
            }
            int divisao = x + y;
            return divisao;
        } catch(NaoParExcepition e){
            System.out.println(e);
            return 0;
        }
    }
}