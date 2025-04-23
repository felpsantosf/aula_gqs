public class FaturaCliente {
    private int id;
    private Cliente cliente;
    private double valor;

    public FaturaCliente(int id, Cliente cliente, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public FaturaCliente(int id) {
        this.id = id;
        this.cliente = null;
        this.valor = 0.0;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorComDesconto() {
        if (cliente != null) {
            return valor * (1 - cliente.getDesconto() / 100.0);
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Fatura [id=" + id + ", cliente=" + (cliente != null ? cliente.toString() : "null") + ", valor=" + valor + "]";
    }
}
