import { AuthorizeLvlService } from './../../../../../core/services/Purchase/authorize-lvl.service';
import { Component, OnInit } from '@angular/core';
import { AuthorizeLvl } from 'src/app/core/models/Purchase/authorizelvl';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthorizeLvlComponent } from '../../authorize-lvl.component';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-auth-lvl-add-modal',
  templateUrl: './auth-lvl-add-modal.component.html',
  styleUrls: ['./auth-lvl-add-modal.component.less']
})
export class AuthLvlAddModalComponent implements OnInit {

	// myForm: NgForm;
	authLvl: AuthorizeLvl = new AuthorizeLvl();
	constructor(private authLvlService: AuthorizeLvlService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	saveAuthLvl(){
			// console.log(this.authLvl);

			this.authLvlService.saveAuthLvl(this.authLvl).subscribe(
				data => {
					// console.log(data['status']+"data");
					this.message.create('success', `Authorize Level Successfully Added!`,{nzDuration:3000});
					this.modalRef.triggerOk();
				},
				error => {
					// console.log(error['status']+"error");
					// console.log(error);
					// this.message.create('success', `Authorize Level Successfully Added!`);
					this.message.create('error', `Authorize Level Not Added!`,{nzDuration:3000});
				}
			);


			// this.modalRef.close();

	}
	onCancel() {
		this.modalRef.triggerCancel();
	}

}
