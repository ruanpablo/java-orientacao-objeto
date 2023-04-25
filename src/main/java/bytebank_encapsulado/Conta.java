package bytebank_encapsulado;

public class Conta {
    private double saldo; //não pode ser acessado a não ser pela própria classe
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total; //esse é um atributo da classe conta, não de um objeto específico.
                                // static - mas compartilha com os objetos

    public Conta (int agencia, int numero) {
        Conta.total = Conta.getTotal() + 1;
//        System.out.println("O total de contas é " + total);
        this.agencia = agencia;
        this.numero = numero;
    }

//    é possível método static
//    dentro de um contexto estático não precisa do this
//    método static só usa atributo estático
    public static int getTotal() {
        return Conta.total;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }
}
