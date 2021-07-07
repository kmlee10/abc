package com.company.abc.controller;

import com.company.abc.domain.Member;
import com.company.abc.domain.Team;
import com.company.abc.dto.MemberInsertDTO;
import com.company.abc.service.MemberService;
import com.company.abc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    TeamService teamService;

    @GetMapping
    public List<Member> getMemberList(){ return memberService.getMembers();}


    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping
    public Member insertMember(@RequestBody MemberInsertDTO dto){
        Team team = teamService.getTeam(dto.getTeamId());

        Member member = new Member();
        member.setName(dto.getName());
        member.setCareer(dto.getCareer());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setJob(dto.getJob());
        member.setTeam(team);

        return memberService.saverMember(member);

    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody MemberInsertDTO dto){
        Team team = teamService.getTeam(dto.getTeamId());

        Member member = memberService.getMember(id);
        member.setName(dto.getName());
        member.setCareer(dto.getCareer());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setJob(dto.getJob());
        member.setTeam(team);

        return  memberService.saverMember(member);
    }


    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
