import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarConsultaComponent } from './visualizar-consulta.component';

describe('VisualizarConsultaComponent', () => {
  let component: VisualizarConsultaComponent;
  let fixture: ComponentFixture<VisualizarConsultaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VisualizarConsultaComponent]
    });
    fixture = TestBed.createComponent(VisualizarConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
