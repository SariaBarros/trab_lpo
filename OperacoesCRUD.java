import java.util.List;

public interface OperacoesCRUD {
    public void create(Animacao nova);
    public List<Animacao> read();
    public void update(Animacao animacao);
    public void delete(Animacao animacao);
}