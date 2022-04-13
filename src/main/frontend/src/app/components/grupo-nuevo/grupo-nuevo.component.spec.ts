import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoNuevoComponent } from './grupo-nuevo.component';

describe('GrupoNuevoComponent', () => {
  let component: GrupoNuevoComponent;
  let fixture: ComponentFixture<GrupoNuevoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GrupoNuevoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoNuevoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
