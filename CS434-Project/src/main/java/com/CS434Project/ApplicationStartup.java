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
        User lecturer1 = Lecturer.getInstance();
        lecturer1.setUserName("lecturer1");
        lecturer1.setPassword("12345");
        if(lecturerRepository.findByUsername(lecturer1.getUserName()) == null)
            lecturerRepository.save((Lecturer)lecturer1);

        User grad1 = GradStudent.getInstance();
        grad1.setUserName("grad1");
        grad1.setPassword("0000");
        if(gradRepository.findByUsername(grad1.getUserName()) == null)
            gradRepository.save((GradStudent) grad1);

        User undergrad1 = UnderGradStudent.getInstance();
        undergrad1.setUserName("undergrad1");
        undergrad1.setPassword("1111");
        if(underGradRepository.findByUsername(undergrad1.getUserName()) == null)
            underGradRepository.save((UnderGradStudent) undergrad1);
    }

}
