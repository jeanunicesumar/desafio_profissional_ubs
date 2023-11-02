import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarDadosPacienteComponent } from './visualizar-dados-paciente.component';

describe('VisualizarDadosPacienteComponent', () => {
  let component: VisualizarDadosPacienteComponent;
  let fixture: ComponentFixture<VisualizarDadosPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VisualizarDadosPacienteComponent]
    });
    fixture = TestBed.createComponent(VisualizarDadosPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
