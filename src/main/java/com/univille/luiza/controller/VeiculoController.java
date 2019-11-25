package com.univille.luiza.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univille.luiza.model.Cliente;
import com.univille.luiza.model.Usuario;
import com.univille.luiza.model.Veiculo;
import com.univille.luiza.service.ClienteService;
import com.univille.luiza.service.VeiculoService;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/veiculo")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public ModelAndView index() {
		List<Veiculo> lista = veiculoService.getAll();
		return new ModelAndView("veiculo/index", "veiculos", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Veiculo cliente) {
		return new ModelAndView("veiculo/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@RequestParam("photo") MultipartFile file, @Valid Veiculo veiculo) throws Exception{
		
		byte[] bytes = file.getBytes(); 

		String imageName = new Timestamp(System.currentTimeMillis()).getTime() + ".png";
		Path path = Paths.get("C:\\Univille\\DSI\\Imagens\\" + imageName);

		veiculo.setImagem(imageName);

		Files.write(path, bytes);
		
		veiculoService.save(veiculo);
		return new ModelAndView("redirect:/veiculo");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Veiculo veiculo) {
		return new ModelAndView("veiculo/form", "veiculo", veiculo);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Veiculo veiculo) {
		veiculoService.delete(veiculo);
		return new ModelAndView("redirect:/veiculo");
	}
	
	@GetMapping("/image-byte-array/{filename}")
	public @ResponseBody byte[] getImageAsByteArray(@PathVariable("filename") String filename) throws IOException {
		try {
		     BufferedImage image = ImageIO.read(new File(String.format("%s/%s", "C:\\Univille\\DSI\\Imagens\\",filename)));
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     String format = filename.substring(filename.length()-3);
		     ImageIO.write(image, format, baos);
		     return baos.toByteArray();
		   } catch (Exception e) {
		   }
		return null;
	}
}
