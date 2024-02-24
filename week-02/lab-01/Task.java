import java.time.LocalDate;
import java.time.Period;

enum State {
  TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {
    // think why private is the WRONG choice here
    // instead, think what should be the access modifier
    final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline; // think why this isn't final
    public State state;

    Task(String title, State state) {
      this.title = title;
      this.state = state;
    }

    Task(String title, State state, LocalDate scheduled) {
      this.title = title;
      this.state = state;
      setDescription(description);
      setScheduled(scheduled);
      setDeadline(deadline);
    }
    
    


public String getTitle() {
    return title;
}

public String getDescription() {
    return this.description;
}

public LocalDate getScheduled() {
    return scheduled;
}

public LocalDate getDeadline() {
    return this.deadline;
}

public State getState() {
    return this.state;
}


// Setters

public void setScheduled(LocalDate scheduled) {
    this.scheduled = scheduled;
}

public void setDescription(String description) { 
    this.description = description; 
}

public void setState(State state) {
    this.state = state;
}

public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
}
public String toString() {
    String message = this.title + " (" + this.state + ")";
    if (scheduled != null) {
        message += " scheduled: " + scheduled;
    }
    if (deadline != null) {
        message += " deadline: " + deadline;
    }
    return message;
  }
}

class RepeatedTask extends Task {
    RepeatedTask(String title, State state) {
        super(title, state);
    }
    @Override
    public void setState(State state) {
        if (state == State.DONE) {
            this.state = State.TODO;
        } else {
            this.state = state;
        }
    }
}

class Chore extends RepeatedTask {
    // think how to use inheritence to avoid repeating fields from Task
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    public LocalDate getRepeat() {
        return repeat;
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }
    @Override
    public void setState(State state) {
        super.setState(state);
        if (state == State.DONE) {
            setScheduled(repeat);
            setRepeat(repeat.plus(Period.ofDays(7)));
        }
    }
}

class SharedTask extends Task {
    String name = "null";
    SharedTask(String title, String name) {
        super(title, State.WAIT);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " shared with: " + name;
    }
}

class Dependency extends Task {
    Task dep;
    Dependency(String title, State state, Task dep) {
        super(title, state);
        this.dep = dep;
    }

    @Override
    public String toString() {
        return super.toString() + " dependent on: " + dep.toString();
    }

    @Override
    public void setState(State state) {
        if (state == State.DONE && !(dep.state == State.DONE)) {
            return;
        }
        this.state = state;
    }
}