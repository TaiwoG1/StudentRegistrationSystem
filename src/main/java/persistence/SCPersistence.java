package persistence;

import java.util.List;

import objects.SC;

public interface SCPersistence {
    List<SC> getSC(final String studentID);

    List<SC> getCS(final String courseID);
}
