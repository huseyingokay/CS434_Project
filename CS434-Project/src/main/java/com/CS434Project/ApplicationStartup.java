package com.CS434Project;

import com.CS434Project.Model.Lecturer.Lecturer;
import com.CS434Project.Model.Student.GradStudent;
import com.CS434Project.Model.Student.UnderGradStudent;
import com.CS434Project.Model.User;
import com.CS434Project.Repository.GradRepository;
import com.CS434Project.Repository.LecturerRepository;
import com.CS434Project.Repository.UnderGradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private GradRepository gradRepository;

    @Autowired
    private UnderGradRepository underGradRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        seedData();
    }

    private void seedData() {
        User lecturer1 = new Lecturer();
        lecturer1.setUserName("amet");
        lecturer1.setPassword("123");
        lecturerRepository.save((Lecturer)lecturer1);

        User grad1 = new GradStudent();
        grad1.setUserName("a");
        grad1.setPassword("123");
        gradRepository.save((GradStudent) grad1);

        User undergrad1 = new UnderGradStudent();
        undergrad1.setUserName("b");
        undergrad1.setPassword("123");
        underGradRepository.save((UnderGradStudent) undergrad1);
    }

}
