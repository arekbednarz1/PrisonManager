package pl.lsab.prisonmanagerproject.web;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lsab.prisonmanagerproject.entity.Cell;
import pl.lsab.prisonmanagerproject.entity.Guard;
import pl.lsab.prisonmanagerproject.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/straznicy")
public class GuardController {


    GuardService guardService;
    AdminService adminService;
    CellService cellService;

    public GuardController(GuardService guardService, AdminService adminService, CellService cellService) {
        this.guardService = guardService;
        this.adminService = adminService;
        this.cellService = cellService;
    }

    @GetMapping()
    public String allGuards(Model guards, Model cells, Model oneGuard){
        Guard guard = new Guard();
        List<Guard> allGuards = guardService.allGuards();
        List<Cell>allCellsWhereNoGuard = cellService.findAllWhereNoGuard();
        guards.addAttribute("guards",allGuards);
        cells.addAttribute("cells",allCellsWhereNoGuard);
        oneGuard.addAttribute("oneGuard",guard);

        return "dashboard/guards/guards";
    }

    @GetMapping("/dodaj")
    public String addGuard(Model model){
        model.addAttribute("guard",new Guard());
        return "dashboard/guards/addGuard";
    }

    @PostMapping("/dodaj")
    public String addGuard(@Valid @ModelAttribute Guard guard, BindingResult result){
        if (result.hasErrors()) {
            return "dashboard/guards/addGuard";
        }
        guardService.save(guard);
        return "redirect:/straznicy";
    }

    @GetMapping("/delete/{id}")
    public String deleteGuard(@PathVariable Long id){
       Guard guard = guardService.findOne(id);
        if(guard.getCell()!=null) {
            cellService.updateCellGuard(null, guard.getCell().getId());
        }
        guardService.delete(id);
        return "redirect:/straznicy";
    }


    @PostMapping()
    public String addCellToGuard(@ModelAttribute Guard guard){
        Guard guard1= new Guard();
        Cell cell1 = new Cell();
        List<Cell>allCells = cellService.findAll();
        if (allCells.size()!=0) {
            if (guard.getCell() == null) {
                cell1 = cellService.findByGuard(guard);
                guardService.setUpdateGuard(null, guard.getId());
                cellService.updateCellGuard(null, cell1.getId());
            } else {
                cell1 = guard.getCell();
                guard1 = guard;
                guard1.setCell(cell1);

                guardService.setUpdateGuard(cell1, guard.getId());
                cellService.updateCellGuard(guard, cell1.getId());
            }
        }
       return "redirect:/straznicy";
        }

    @GetMapping("/search")
    public String searchGuards(@Param("keyword") String keyword, Model guards, Model cells, Model oneGuard){
        Guard guard = new Guard();
        String word = keyword;
        List<Guard> guardSearchList = guardService.searchGuard(word);
        List<Cell>allCellsWhereNoGuard = cellService.findAllWhereNoGuard();
        guards.addAttribute("guards",guardSearchList);
        cells.addAttribute("cells",allCellsWhereNoGuard);
        oneGuard.addAttribute("oneGuard",guard);

        return "dashboard/guards/guards";
    }


}

