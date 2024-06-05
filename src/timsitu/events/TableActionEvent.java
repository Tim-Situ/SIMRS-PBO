package timsitu.events;

public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onClick(int row);
}
