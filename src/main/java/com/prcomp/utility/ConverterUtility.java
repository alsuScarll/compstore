package com.prcomp.utility;

import org.springframework.stereotype.Service;

import com.prcomp.dto.CPUDTO;
import com.prcomp.dto.ComputerDTO;
import com.prcomp.dto.GPUDTO;
import com.prcomp.dto.OSDTO;
import com.prcomp.dto.ProducerDTO;
import com.prcomp.model.CPU;
import com.prcomp.model.Computer;
import com.prcomp.model.GPU;
import com.prcomp.model.OS;
import com.prcomp.model.Producer;

@Service
public class ConverterUtility {

    public Computer convertDTOToEntity(ComputerDTO computerDto) {
        Computer computer = new Computer();
        computer.setId(computerDto.getId());
        computer.setName(computerDto.getName());
        computer.setProducer(convertDTOToEntity(computerDto.getProducer()));
        computer.setPrice(computerDto.getPrice());
        computer.setDescription(computerDto.getDescription());
        computer.setRam(computerDto.getRam());
        computer.setCpu(convertDTOToEntity(computerDto.getCpu()));
        computer.setRom(computerDto.getRom());
        computer.setRomType(computerDto.getRomType());
        computer.setOs(convertDTOToEntity(computerDto.getOs()));
        computer.setGpu(convertDTOToEntity(computerDto.getGpu()));
        computer.setImgURL(computerDto.getImgURL());
        
        return computer;
    }

    public CPU convertDTOToEntity(CPUDTO cpuDto) {
        CPU cpu = new CPU();
        cpu.setId(cpuDto.getId());
        cpu.setName(cpuDto.getName());
        cpu.setGen(cpuDto.getGen());
        cpu.setPower(cpuDto.getPower());
        cpu.setCore(cpuDto.getCore());
        
        return cpu;
    }

    public GPU convertDTOToEntity(GPUDTO gpuDto) {
        GPU gpu = new GPU();
        gpu.setId(gpuDto.getId());
        gpu.setName(gpuDto.getName());
        gpu.setMemory(gpuDto.getMemory());
        gpu.setPrototype(gpuDto.getPrototype());
        
        return gpu;
    }

    public OS convertDTOToEntity(OSDTO osDto) {
        OS os = new OS();
        os.setId(osDto.getId());
        os.setName(osDto.getName());
        os.setVersion(osDto.getVersion());
        
        return os;
    }

    public Producer convertDTOToEntity(ProducerDTO producerDto) {
        Producer producer = new Producer();
        producer.setId(producerDto.getId());
        producer.setName(producerDto.getName());
        
        return producer;
    }

    public ComputerDTO convertEntityToDTO(Computer computer) {
        ComputerDTO computerDto = new ComputerDTO();
        computerDto.setId(computer.getId());
        computerDto.setName(computer.getName());
        computerDto.setProducer(convertEntityToDTO(computer.getProducer()));
        computerDto.setPrice(computer.getPrice());
        computerDto.setDescription(computer.getDescription());
        computerDto.setRam(computer.getRam());
        computerDto.setCpu(convertEntityToDTO(computer.getCpu()));
        computerDto.setRom(computer.getRom());
        computerDto.setRomType(computer.getRomType());
        computerDto.setOs(convertEntityToDTO(computer.getOs()));
        computerDto.setGpu(convertEntityToDTO(computer.getGpu()));
        computerDto.setImgURL(computer.getImgURL());
        
        return computerDto;
    }

    public CPUDTO convertEntityToDTO(CPU cpu) {
        CPUDTO cpuDto = new CPUDTO();
        cpuDto.setId(cpu.getId());
        cpuDto.setName(cpu.getName());
        cpuDto.setGen(cpu.getGen());
        cpuDto.setPower(cpu.getPower());
        cpuDto.setCore(cpu.getCore());
        
        return cpuDto;
    }

    public GPUDTO convertEntityToDTO(GPU gpu) {
        GPUDTO gpuDto = new GPUDTO();
        gpuDto.setId(gpu.getId());
        gpuDto.setName(gpu.getName());
        gpuDto.setMemory(gpu.getMemory());
        gpuDto.setPrototype(gpu.getPrototype());
        
        return gpuDto;
    }

    public OSDTO convertEntityToDTO(OS os) {
        OSDTO osDto = new OSDTO();
        osDto.setId(os.getId());
        osDto.setName(os.getName());
        osDto.setVersion(os.getVersion());
        
        return osDto;
    }

    public ProducerDTO convertEntityToDTO(Producer producer) {
        ProducerDTO producerDto = new ProducerDTO();
        producerDto.setId(producer.getId());
        producerDto.setName(producer.getName());
        
        return producerDto;
    }

}
