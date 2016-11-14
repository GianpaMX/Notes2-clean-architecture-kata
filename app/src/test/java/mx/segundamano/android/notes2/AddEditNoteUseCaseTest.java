package mx.segundamano.android.notes2;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pablo on 11/11/16.
 */
public class AddEditNoteUseCaseTest {
    @Test
    public void save() throws Exception {
        NotesRepository repository = mock(NotesRepository.class);
        ArgumentCaptor<Note> argumentCaptor = ArgumentCaptor.forClass(Note.class);
        Date beforeSaving = new Date();
        AddEditNoteUseCase addEditNoteUseCase = new AddEditNoteUseCase(repository);

        addEditNoteUseCase.save("note body", mock(AddEditCallback.class));

        verify(repository).persist(argumentCaptor.capture(), any(RepositoryCallback.class));
        Note note = argumentCaptor.getValue();
        assertEquals("note body", note.body);
        assertTrue(note.date.getTime() >= beforeSaving.getTime());
    }

    @Test
    public void onSuccess() throws Exception {

    }

    @Test
    public void onError() throws Exception {

    }
}