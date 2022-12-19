import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Upitnik} from "../personal-info/upitnik";

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Output() questionsEmitter = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  upitnik: Upitnik = {
    id: 0,
    dobrovoljan: false,
    odbijen: false,
    lekovi: false,
    nahranjen: false,
    tetoviran: false
  }

  onChange() {
    console.log('sadaewddsc');
    this.questionsEmitter.emit(this.upitnik);
  }
}
