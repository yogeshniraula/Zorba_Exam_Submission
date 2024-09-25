package org.springMVC.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springMVC.entity.Inventory;
import org.springMVC.entity.InventoryCategory;
import org.springMVC.exception.CustomDataIntegrityViolationException;
import org.springMVC.model.InventoryModel;
import org.springMVC.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Controller
public class InventoryController {

    private InventoryService inventoryService;// Replace with your service to save data to DB

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/uploadRequest")
    public ModelAndView uploadReq(){
        ModelAndView modelAndView = new ModelAndView("inventoryExcel");
        return modelAndView;
    }

    @PostMapping("/fileUpload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadRequest";
        }

        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            // Assuming the Excel file has only one sheet
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip the header row
            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                Cell categoryCell = currentRow.getCell(0);
                String category = categoryCell.getStringCellValue();
                //InventoryCategory category =  (InventoryCategory) cellValue;
                String name = currentRow.getCell(1).getStringCellValue();
                int quantity = (int) currentRow.getCell(2).getNumericCellValue();
                Double price = currentRow.getCell(3).getNumericCellValue();
                String description = currentRow.getCell(4).getStringCellValue();

                // Create an entity (Inventory in this case)
                InventoryModel inventory = new InventoryModel();
                inventory.setName(name);
                inventory.setCategory(inventoryService.processCategory(category));
                inventory.setQuantity(quantity);
                inventory.setPrice(price);
                inventory.setDescription(description);

                // Save to the database
                inventoryService.saveInventory(inventory);
            }

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "File upload failed!");
            return "redirect:/uploadRequest";
        }

        redirectAttributes.addFlashAttribute("message", "File uploaded and data saved successfully!");
        return "redirect:/viewInventory";
    }

    @GetMapping("/viewInventory")
    public String viewInventory(Model model) throws CustomDataIntegrityViolationException {
        List<InventoryModel> inventory = inventoryService.getAllInventory();
        model.addAttribute("inventory", inventory);
        return "viewInventory.jsp";
    }
}

