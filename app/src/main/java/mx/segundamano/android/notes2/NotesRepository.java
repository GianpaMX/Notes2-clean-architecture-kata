package mx.segundamano.android.notes2;

public interface NotesRepository {
    void persist(Note note, RepositoryCallback callback);
}
