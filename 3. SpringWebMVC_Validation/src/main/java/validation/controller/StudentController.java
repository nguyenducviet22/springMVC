package validation.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import validation.model.Student;

@Controller
public class StudentController {

	@RequestMapping(value = { "/", "initStudent" })
	public String initStudent(Model model) {
		Student student = new Student();
		model.addAttribute("stu", student);
		return "insertStudent";
	}

	@RequestMapping(value = "insertStudent")
	public String insertStudent(@Valid @ModelAttribute("stu") Student student, BindingResult result,
			@RequestParam("imageSource") MultipartFile imgData, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("stu", student);
			return "insertStudent";
		} else {
			String path = request.getServletContext().getRealPath("resources/images");
			File file = new File(path);
			File destination = new File(file.getAbsolutePath()+"/"+imgData.getOriginalFilename());
			if (!destination.exists()) {
				try {
					Files.write(destination.toPath(), imgData.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			student.setImage(imgData.getOriginalFilename());
			model.addAttribute("stu", student);
			return "home";
		}

	}
}
