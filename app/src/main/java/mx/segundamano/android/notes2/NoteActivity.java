package mx.segundamano.android.notes2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class NoteActivity extends AppCompatActivity implements AddEditNoteView {

    private EditText noteEditText;
    private AddEditNotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        noteEditText = (EditText) findViewById(R.id.note_edit_text);

        Realm realm = Realm.getDefaultInstance();
        NotesRepository repository = new RealmRepository(realm);
        AddEditNoteModel model = new AddEditNoteModel(repository);
        presenter = new AddEditNotePresenter(this, model);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.note_action_save)  {
            presenter.save(noteEditText.getText().toString());
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoteSaved(NoteViewModel viewModel) {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
